/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.infobip.spring.data.jdbc.extension;

import com.infobip.spring.data.jdbc.QuerydslJdbcRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import java.io.Serializable;

public class CustomQuerydslJdbcRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
        extends QuerydslJdbcRepositoryFactoryBean<T, S, ID> {

    protected CustomQuerydslJdbcRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport doCreateRepositoryFactory() {

        RepositoryFactorySupport repositoryFactorySupport = super.doCreateRepositoryFactory();
        repositoryFactorySupport.setRepositoryBaseClass(SimpleCustomQuerydslJdbcRepository.class);
        return repositoryFactorySupport;
    }
}
