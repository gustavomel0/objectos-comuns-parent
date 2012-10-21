/*
 * Copyright 2011 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.comuns.relational.jdbc;

import java.sql.SQLException;

import com.google.inject.ImplementedBy;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@ImplementedBy(TransactionsGuice.class)
public interface Transactions {

  interface AtomicInsertOperation {
    void execute(Insertion insertion) throws SQLException;
  }

  interface AtomicUpdateOperation<I extends Insertable> {
    I execute(Update update) throws SQLException;
  }

  interface Update {
    void of(PrimaryKey key, Insertable entity) throws SQLException;
  }

  void execute(AtomicInsertOperation operation) throws TransactionRolledbackException;

  <I extends Insertable> I executeUpdate(AtomicUpdateOperation<I> operation)
      throws TransactionRolledbackException;

}