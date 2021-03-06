/*
Copyright (c) 2018 Ericsson

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE. SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.ericsson.commonlibrary.proxy.external;

import java.lang.reflect.Method;

import com.ericsson.commonlibrary.proxy.JavaBeanSignedJarTest;
import com.ericsson.commonlibrary.proxy.Proxy;

/**
 * This is the example class of the class <b>ExternalEntry</b> in src/test/resources/external.jar and external-sign.jar.
 * The signed jar - external-sign.jar is used for generating class from singed jar, covered in {@link JavaBeanSignedJarTest}.
 *
 */
public class ExternalEntry1 {

	public static void main(String[] args) {
		JavaBean41 proxyBean = Proxy.javaBean(JavaBean41.class);
		invokeSetName(proxyBean, "nisse");
        if ("nisse".equals(proxyBean.getName())) {
        	System.out.println("Setter for proxy bean works.");
        }
	}

	private static void invokeSetName(Object proxyBean, String name) {
        Method method = null;
        try {
            method = proxyBean.getClass().getMethod("setName", String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            method.invoke(proxyBean, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
