package com.asiaInfo.core;

import com.asiaInfo.exception.MyException;
import com.asiaInfo.model.Message;
import com.asiaInfo.util.DatabaseContextHolder;
import com.asiaInfo.util.DatabaseType;
import com.asiaInfo.common.RoutConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

    /**
     * 使用空方法定义切点表达式
     */
    @Pointcut("execution(* com.asiaInfo.service.*.*(..))")
    public void declareJointPointExpression() {
    }

    @Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point) throws MyException {
        //根据连接点所属的类实例，动态切换数据源
        if(point.getArgs() != null){
            Object objs [] = point.getArgs();
            for (Object obj : objs){
                if(obj instanceof Message){
                    Message message = (Message) obj;
                    setRouting(message);
                }
            }
        } else {//连接点所属的类实例是（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
            setPrimaryDataBaseType();
        }
    }

    private void setPrimaryDataBaseType(){
        DatabaseContextHolder.setDatabaseType(DatabaseType.guangdong);
    }

    /**
     * 根据消息rout设置路由
     * @param message
     */
    private void setRouting(Message message) throws MyException {
        if(message.getRoute() == null){
            message.setRoute(message.getTeamKey());
        }if(message.getRoute() == null){
            throw new MyException("请在入参里设置路由routId");
        }
        if(message.getRoute().equals(RoutConstants.jiangshu.getCode())){
            DatabaseContextHolder.setDatabaseType(DatabaseType.jianshu);
        }else if(message.getRoute().equals(RoutConstants.guangdong.getCode())){
            DatabaseContextHolder.setDatabaseType(DatabaseType.guangdong);
        }else {
            throw new MyException("入参路由标不正确，请检查：" + message.getRoute());
        }
    }
}