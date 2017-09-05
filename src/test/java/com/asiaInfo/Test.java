package com.asiaInfo;

import com.asiaInfo.common.RoutConstants;

/**
 * Created by wxwall on 2017/9/2.
 */
public class Test {
    public static void main(String[] args) {
        RoutConstants.guangdong.getCode();

        for(RoutConstants aa : RoutConstants.values()){
            System.out.println(aa.getCode());
        }
    }
}
