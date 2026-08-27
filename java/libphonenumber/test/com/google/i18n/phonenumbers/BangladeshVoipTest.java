/*
 * Copyright (C) 2024 The Libphonenumber Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import junit.framework.TestCase;

/**
 * Tests for Bangladesh (BD) VOIP numbers validation and classification.
 */
public class BangladeshVoipTest extends TestCase {

  private PhoneNumberUtil phoneUtil;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    phoneUtil = PhoneNumberUtil.getInstance();
  }

  public void testBangladeshVoipNumberValidation_9647Prefix() throws Exception {
    String nationalNumberStr = "09647100123";
    PhoneNumber parsedNumber = phoneUtil.parse(nationalNumberStr, "BD");

    assertEquals(880, parsedNumber.getCountryCode());
    assertEquals(9647100123L, parsedNumber.getNationalNumber());

    assertTrue(
        "VOIP number 09647100123 should be valid",
        phoneUtil.isValidNumber(parsedNumber));
    assertTrue(
        "VOIP number 09647100123 should be valid for region BD",
        phoneUtil.isValidNumberForRegion(parsedNumber, "BD"));
    assertEquals(
        PhoneNumberType.VOIP,
        phoneUtil.getNumberType(parsedNumber));
  }

  public void testBangladeshVoipNumberValidation_InternationalFormat() throws Exception {
    String intlNumberStr = "+8809647100123";
    PhoneNumber parsedNumber = phoneUtil.parse(intlNumberStr, "ZZ");

    assertEquals(880, parsedNumber.getCountryCode());
    assertEquals(9647100123L, parsedNumber.getNationalNumber());

    assertTrue(
        "VOIP number +8809647100123 should be valid",
        phoneUtil.isValidNumber(parsedNumber));
    assertTrue(
        "VOIP number +8809647100123 should be valid for region BD",
        phoneUtil.isValidNumberForRegion(parsedNumber, "BD"));
    assertEquals(
        PhoneNumberType.VOIP,
        phoneUtil.getNumberType(parsedNumber));
  }
}
