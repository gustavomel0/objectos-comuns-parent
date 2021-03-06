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
package br.com.objectos.comuns.matematica.financeira;

import java.math.BigDecimal;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class FakeQuantity extends AbstractQuantity {

  private static final long serialVersionUID = 1L;

  public FakeQuantity(BigDecimal val) {
    super(val);
  }

  public FakeQuantity(double val) {
    super(val);
  }

  public FakeQuantity(String val) {
    super(val);
  }

  @Override
  protected ValorFinanceiro newMonetaryValue(BigDecimal value) {
    return new FakeMonetaryValue(value);
  }

  @Override
  protected Quantidade newQuantity(BigDecimal value) {
    return new FakeQuantity(value);
  }

}