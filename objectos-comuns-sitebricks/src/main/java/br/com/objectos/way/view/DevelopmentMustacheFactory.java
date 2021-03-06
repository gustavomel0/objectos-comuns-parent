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
package br.com.objectos.way.view;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class DevelopmentMustacheFactory extends DefaultMustacheFactory {

  public DevelopmentMustacheFactory(String resourceRoot) {
    super(resourceRoot);
  }

  @Override
  protected LoadingCache<String, Mustache> createMustacheCache() {
    return CacheBuilder
        .newBuilder()
        .maximumSize(0)
        .build(new MustacheCacheLoader());
  }

  private class MustacheCacheLoader extends CacheLoader<String, Mustache> {
    @Override
    public Mustache load(String key) throws Exception {
      return mc.compile(key);
    }
  }

}