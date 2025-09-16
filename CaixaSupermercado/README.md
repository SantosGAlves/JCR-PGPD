# Análise Experimental de um Simulador de Caixas de Supermercado

Este documento apresenta os resultados e a análise de uma simulação de atendimento em caixas de supermercado, com o objetivo de entender o impacto de diferentes variáveis no tempo total de serviço.

---

### **1. Simulação Base**

A primeira execução estabeleceu uma linha de base para a análise.

* **Parâmetros:**
    * Média de Atendimento ($\mu$): `5,0 min`
    * Desvio-Padrão ($\sigma$): `0,5`
    * Número de Clientes (N): `100`
    * Número de Rodadas: `1000`
    * Número de Caixas: `1`
* **Resultados Obtidos:**
    * Média do Tempo Total: **`499,988 min`**
    * Desvio-Padrão do Tempo Total: **`4,987 min`**

---

### **2. Análise de Desempenho com Múltiplos Caixas**

Nesta etapa, o número de caixas foi variado para observar o impacto no tempo total de atendimento.

| Número de Caixas | Média do Tempo Total (min)   |
| :--------------: | :--------------------------: |
|        1         |          `499,988`           |
|        2         |          `251,236`           |
|        3         |          `168,384`           |

> #### Discussão
> Os resultados demonstram que adicionar mais caixas reduz drasticamente o tempo total de atendimento. Isso ocorre devido ao **paralelismo**: a carga de trabalho total (a soma de todos os tempos de serviço) é distribuída entre os caixas disponíveis. Com dois caixas, o tempo é quase reduzido pela metade, e com três, a uma terça parte, comprovando a eficácia de múltiplos pontos de atendimento para aumentar a vazão do sistema.

---

### **3. Análise do Impacto da Variabilidade ($\sigma$)**

Aqui, o número de caixas foi mantido em `2`, enquanto o desvio-padrão ($\sigma$) do tempo de atendimento foi variado para medir seu efeito na previsibilidade do sistema.

| Desvio-Padrão ($\sigma$) | Média do Tempo Total (min) | Desvio-Padrão do Tempo Total (min) |
| :----------------------: | :------------------------: | :----------------------------------: |
|           0.25           |         `250,949`          |               `1,415`                |
|           0.50           |         `251,236`          |               `2,594`                |
|           1.00           |         `251,267`          |               `5,037`                |
|           2.00           |         `251,681`          |               `9,931`                |

> #### Discussão
> Aumentar a variabilidade ($\sigma$) não altera significativamente a *média* do tempo total, que permanece estável. No entanto, eleva drasticamente o *desvio-padrão dos resultados*. Isso significa que, embora o desempenho médio seja o mesmo, um sistema com alta variabilidade é muito menos previsível. Um $\sigma$ alto pode levar a cenários onde, ocasionalmente, o tempo de atendimento total é muito maior (ou menor) que a média esperada.

---

### **4. Natureza Estocástica do Simulador**

> Um processo **estocástico** é aquele governado por variáveis aleatórias, cujo comportamento não é totalmente previsível, mas segue distribuições de probabilidade. Este simulador é considerado estocástico porque o tempo de atendimento de cada cliente não é um valor fixo, mas uma amostra de uma distribuição normal. Isso representa fielmente situações reais, onde o tempo de serviço varia de forma imprevisível devido a fatores como a quantidade de produtos de cada cliente, problemas com código de barras, método de pagamento ou conversas com o operador.