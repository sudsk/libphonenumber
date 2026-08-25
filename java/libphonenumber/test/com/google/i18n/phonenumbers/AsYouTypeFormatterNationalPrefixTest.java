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

import junit.framework.TestCase;

public class AsYouTypeFormatterNationalPrefixTest extends TestCase {

  public void testRURuleApplied() {
    // We use the real instance instead of the TestMetadataTestCase to ensure we get
    // the full metadata rules, including the proper formats for RU.
    PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    AsYouTypeFormatter formatter = phoneUtil.getAsYouTypeFormatter("RU");
    
    String number = "89123456789";
    String lastResult = "";
    for (int i = 0; i < number.length(); i++) {
      lastResult = formatter.inputDigit(number.charAt(i));
    }
    
    // The current output without the fix is "8 912 345-67-89".
    // With the fix correctly applying the nationalPrefixFormattingRule "$NP ($FG)",
    // it will correctly wrap the first group (area code) in parentheses.
    assertEquals("8 (912) 345-67-89", lastResult);
  }

}