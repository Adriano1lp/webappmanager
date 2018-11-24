O objetivo desse projeto é migrar uma plicação desktop escrito em java puro para webservice.
A aplicação original foi escrita em java com a finalidade de registrar informações de cada peça 
que era recebida do cliente. Essas informações eram imclementadas em cada etapa de produção que 
ocorria com a peça.

As informações de entrada inseridas manualmente são:
    * numero de serie
    * numero de casid
    * numero do mac
    * modelo
    * codigo do modelo
    * nota fiscal entrada 
    * data de entrada
    * numero do pedido de entrada
    * usuario de entrada
    * observação de entrada

As informações de Reparo são:
    * numero de serie ou casid
    * data de Reparo
    * tipo de reparo (Reparo, Triagem ou S.C.R)
    * defito
    * Observações
    * usuario de reparo

A informações de controle de qualidade são:
    * numero de serie ou casid
    * data do cq
    * status do cq (Aprovado ou Reprovado)
    * Observações 
    * usuario de cq

### FUNÇÔES PRINCIPAIS
Salvar as informaçoes de entrada de forma manual ou pela base de dados, atualizar as informações
de entrada a cada etapa de produção, gerar relatorio quando a peça passar pelo setor de embalagem,
relatorio deve conter informações de notas de entrada e saida, o diagnostico do reparo efetuado além de 
conter as informações de serie, casid, modelo e codigo de modelo. Todas as informações do relatorio de 
todas as peças embalada no mesmo dia devem ser importadas para excel. 
 
Tambem deve ser possivel calcular a quantidade produzida por cada funcionario, calcular a quantidade de 
peças que foram reparas e dadas como sem condição de reparo (S.C.R), calcular a quantidade de peças em cada 
nota fiscal de entrada, calcular a quantidade de cada modelo, quantidade de cada pedido de entrada e saida.

Imprimir as etiquetas de informação e embalagem para cada peça. 

Fazer backup das informções a cada relatorio emitido 

