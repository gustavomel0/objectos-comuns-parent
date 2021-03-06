/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.comuns.sitebricks;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CookieMap {

  private final Map<String, String> map = newHashMap();

  public CookieMap(ServletRequest _request) {
    HttpServletRequest request = (HttpServletRequest) _request;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {

      for (Cookie cookie : cookies) {
        String name = cookie.getName();
        String value = cookie.getValue();

        map.put(name, value);
      }
    }
  }

  public String get(String name) {
    return map.get(name);
  }

}