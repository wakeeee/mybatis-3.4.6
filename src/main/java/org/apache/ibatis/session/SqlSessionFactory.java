/**
 *    Copyright 2009-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.session;

import java.sql.Connection;

/**
 * Creates an {@link SqlSession} out of a connection or a DataSource
 * Session工厂,mybatis核心接口
 * 通常来说,我们在获取Session时,需要考虑几点:
 *    1.事务相关:是否自动提交事务、事务的隔离级别
 *    2.数据库连接:用配置好的数据源的Connection,还是自定义的Connection
 *    3.语句执行类型:SIMPLE,REUSE,BATCH
 *        3.1.SIMPLE:默认值-简单类型.每次sql的执行,都创建一个PreparedStatement,执行完sql就关闭.
 *        3.2.REUSE:复用类型.这类执行器,在一个Session的生命周期内,会复用PreparedStatement.
 *        3.3.BATCH:批处理类型.
 *
 *
 * @author Clinton Begin
 */
public interface SqlSessionFactory {

  SqlSession openSession();

  SqlSession openSession(boolean autoCommit);
  SqlSession openSession(Connection connection);
  SqlSession openSession(TransactionIsolationLevel level);

  SqlSession openSession(ExecutorType execType);
  SqlSession openSession(ExecutorType execType, boolean autoCommit);
  SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level);
  SqlSession openSession(ExecutorType execType, Connection connection);

  /**
   * 获取当前Session工厂的配置信息,返回Configuration对象.
   * @return
   */
  Configuration getConfiguration();

}
