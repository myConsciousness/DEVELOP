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

package com.utilkit.java.CalendarHandler;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <DL>
 * <DT>Description:</DT>
 * <DD>
 * This interface was created to define the basic but useful functions for manipulating the enum class of calendar information.<br>
 * Japanese name and English name operations are supported.<br>
 * </DD>
 * </DL>
 *
 * @author Kato Shinya
 * @since 2019.02.16
 * @version 1.0
 */
public interface ICalendarInfoEnum<E extends Enum<E>> {

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get the value of code.<br>
	 * It returns the code value of implemented enum.<br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the value of code value
	 */
	public int getCode();

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get the value of Japanese name.<br>
	 * It returns the Japanese name of implemented enum.<br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the value of Japanese name
	 */
	public String getJapaneseName();

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get the value of English name.<br>
	 * It returns the English name of implemented enum.<br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the value of English name
	 */
	public String getEnglishName();

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get the value of order.<br>
	 * It returns the order of implemented enum.<br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the value of order
	 */
	public int getOrder();

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get enum.<br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns {@code ICalendarInfo<E>}
	 */
	@SuppressWarnings("unchecked")
	default E toEnum() {
		return (E) this;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get boolean the arugument is equal to the value of code.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param code [i] Value of code
	 * @return Returns {@code true} if the argument is equal to the value of code, or {@code false}
	 */
	default boolean equalsByCode(int code) {
		return code == getCode();
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get ordered list of enum.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param <E> [i] Nonboundary wildcard type
	 * @param enumType [i] Enum class to get ordered list
	 * @return Returns ordered list of enum
	 */
	public static <E extends Enum<E>> List<E> getOrderedList(Class<? extends ICalendarInfoEnum<E>> enumType) {

		return Arrays.stream(enumType.getEnumConstants())
				.sorted(Comparator.comparing(ICalendarInfoEnum::getOrder))
				.map(ICalendarInfoEnum::toEnum)
				.collect(Collectors.toList());
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get map of enum.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param <E> [i] Nonboundary wildcard type
	 * @param enumType [i] Enum class to get map
	 * @return Returns map of enum
	 */
	public static <E extends Enum<E>> Map<Integer, E> getMap(Class<? extends ICalendarInfoEnum<E>> enumType) {

		return Arrays.stream(enumType.getEnumConstants())
				.collect(Collectors.toMap(ICalendarInfoEnum::getCode, ICalendarInfoEnum::toEnum));
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get boolean enum has the code value of the arugument or not.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param <E> [i] Nonboundary wildcard type
	 * @param enumType [i] Enum class to compared with the argument
	 * @param code [i] Value of code
	 * @return Returns {@code true} if enum class has the code value of the argument, or {@code false}
	 */
	public static <E extends Enum<E>> boolean hasCode(Class<? extends ICalendarInfoEnum<E>> enumType, int code) {

		final ICalendarInfoEnum<E>[] enumClass = enumType.getEnumConstants();

		for (ICalendarInfoEnum<E> e : enumClass) {
			if (e.equalsByCode(code)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get boolean enum has the Japanese name or English name or not.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param <E> [i] Nonboundary wildcard type
	 * @param enumType [i] Enum class to compared with the argument
	 * @param code [i] Value of name
	 * @return Returns {@code true} if enum class has the value of the argument, or {@code false}
	 */
	public static <E extends Enum<E>> boolean hasName(Class<? extends ICalendarInfoEnum<E>> enumType, String name) {

		final ICalendarInfoEnum<E>[] enumClass = enumType.getEnumConstants();

		for (ICalendarInfoEnum<E> e : enumClass) {
			if (e.getJapaneseName().equals(name)
					|| e.getEnglishName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get enum class associated with the code value.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param <E> [i] Nonboundary wildcard type
	 * @param enumType [i] Enum class to compared with the argument
	 * @param code [i] Value of code
	 * @return Returns enum class associated with the code value
	 * @throws IllegalArgumentException throws when the argument is not valid
	 */
	public static <E extends Enum<E> & ICalendarInfoEnum<E>> E getByCode(Class<E> enumType, int code) {

		return Stream.of(enumType.getEnumConstants())
				.filter(e -> e.equalsByCode(code))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException());
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get enum class associated with the Japanese name.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param <E> [i] Nonboundary wildcard type
	 * @param enumType [i] Enum class to compared with the argument
	 * @param japaneseName [i] Value of Japanese name
	 * @return Returns enum class associated with the Japanese name
	 * @throws IllegalArgumentException throws when the argument is not valid
	 */
	public static <E extends Enum<E> & ICalendarInfoEnum<E>> E getByJapaneseName(Class<E> enumType, String japaneseName) {

		return Stream.of(enumType.getEnumConstants())
				.filter(e -> e.getJapaneseName().equals(japaneseName))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException());
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This method is used to get enum class associated with the English name.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param <E> [i] Nonboundary wildcard type
	 * @param enumType [i] Enum class to compared with the argument
	 * @param englishName [i] Value of English name
	 * @return Returns enum class associated with the English name
	 * @throws IllegalArgumentException throws when the argument is not valid
	 */
	public static <E extends Enum<E> & ICalendarInfoEnum<E>> E getByEnglishName(Class<E> enumType, String englishName) {

		return Stream.of(enumType.getEnumConstants())
				.filter(v -> v.getEnglishName().equals(englishName))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException());
	}
}
