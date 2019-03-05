/**
 * Copyright (c) 2019 Kato Shinya
 * Released under the MIT license
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.utilkit.java.common;

/**
 * <DL>
 * <DT>Description:</DT>
 * <DD>
 * Provide the function to check String.<br>
 * </DD>
 * </DL>
 *
 * @author Kato Shinya
 * @since 2019.02.16
 * @version 1.0
 */
public class StringChecker {

	private StringChecker() {}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Check if String is valid or not.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param str [i] Value of string
	 * @return Returns {@code true} if string is valid, or {@code false}
	 */
	public static boolean isEffectiveString(String str) {

		return str != null && str.length() > 0 ? true : false;
	}
}
