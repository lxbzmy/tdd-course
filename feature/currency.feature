#language: zh-CN
功能: 按照现行汇率计算账户余额
  
  给一个支持多币种的账户计算余额

  背景: 
    假定100外币换CNY汇率表
      | USD | 659.7600 |
      | HKD |    84.92 |
      | JPY |   5.9162 |
      | EUR |   762.83 |

  场景: 本币相加
    * 存入CNY100.99
    * 存入CNY100.99
    那么合计是CNY201.98

  场景: 多币种相加
    * 存入CNY100.99
    * 存入USD100
    那么合计是CNY760.75
    那么合计是USD115.31