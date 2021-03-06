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
package br.com.objectos.comuns.cnab;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class OcorrenciaPadrao implements Ocorrencia {

  private final OcorrenciaCodigoPadrao codigo;

  private final OcorrenciaTipo tipo;

  private final List<Motivo> motivos;

  public OcorrenciaPadrao(OcorrenciaCodigoPadrao codigo, List<Motivo> motivos) {
    this.codigo = codigo;
    this.tipo = codigo.getTipo();
    this.motivos = ImmutableList.copyOf(motivos);
  }

  @Override
  public OcorrenciaCodigo getCodigo() {
    return codigo;
  }

  @Override
  public OcorrenciaTipo getTipo() {
    return tipo;
  }

  @Override
  public String getDescricao() {
    return codigo.getDescricao();
  }

  @Override
  public List<Motivo> getMotivos() {
    return motivos;
  }

}