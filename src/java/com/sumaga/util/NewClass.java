/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sumaga.util;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author vertec-r
 */
public class NewClass {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(new MD5Hashing().encryptByteToHex("123"));
    }
}
