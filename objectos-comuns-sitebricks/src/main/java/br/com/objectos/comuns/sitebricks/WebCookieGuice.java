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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Singleton
class WebCookieGuice implements WebCookie {

  private final Provider<HttpServletResponse> responses;

  @Inject
  public WebCookieGuice(Provider<HttpServletResponse> responses) {
    this.responses = responses;
  }

  @Override
  public void add(Cookie cookie) {
    HttpServletResponse response = responses.get();
    response.addCookie(cookie);
  }

}