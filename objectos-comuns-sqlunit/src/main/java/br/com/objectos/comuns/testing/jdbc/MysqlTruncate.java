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
package br.com.objectos.comuns.testing.jdbc;

import java.sql.Connection;

import br.com.objectos.comuns.relational.jdbc.SQLProvider;

import com.google.inject.Inject;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class MysqlTruncate extends AbstractTruncate {

  @Inject
  public MysqlTruncate(SQLProvider<Connection> connections) {
    super(connections);
  }

  @Override
  String getDisableReferentialIntegritySql() {
    return "set foreign_key_checks=0;";
  }

  @Override
  String getTruncateTableSql(String name) {
    return String.format("truncate table %s", name);
  }

  @Override
  String getEnableReferentialIntegritySql() {
    return "set foreign_key_checks=1;";
  }

}