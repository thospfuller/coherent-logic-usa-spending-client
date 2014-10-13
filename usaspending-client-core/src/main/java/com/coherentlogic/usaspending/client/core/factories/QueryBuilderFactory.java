package com.coherentlogic.usaspending.client.core.factories;

import org.springframework.web.client.RestTemplate;

import com.coherentlogic.coherent.data.model.core.cache.CacheServiceProviderSpecification;
import com.coherentlogic.coherent.data.model.core.factories.Factory;
import com.coherentlogic.usaspending.client.core.builders.QueryBuilder;

/**
 * A factory which is used for creating instances of QueryBuilder.
 * <p>
 * Since the QueryBuilder is not thread-safe, it cannot be set as a member
 * variable -- instead, use this factory and call {@link #getInstance()}
 * whenever you need to query the USA Spending web services.
 * <p>
 * This class can be extended, for example, if you need to always return the
 * same value for some query parameter -- for example, in this class we always
 * return the same API key.
 * <p>
 * @author <a href="support@coherentlogic.com">Support</a>
 */
public class QueryBuilderFactory
    implements Factory<QueryBuilder> {

    private final RestTemplate restTemplate;

    private final String uri;

    private final CacheServiceProviderSpecification<String, Object>
        cacheServiceProviderSpecification;

    public QueryBuilderFactory (
        RestTemplate restTemplate,
        String uri,
        CacheServiceProviderSpecification<String, Object>
            cacheServiceProviderSpecification
    ) {
        this.restTemplate = restTemplate;
        this.uri = uri;
        this.cacheServiceProviderSpecification =
            cacheServiceProviderSpecification;
    }

    @Override
    public QueryBuilder getInstance() {

        QueryBuilder result = new QueryBuilder (
            restTemplate, uri, cacheServiceProviderSpecification);
        System.out.println("RETURNING A NEW INSTANCE OF QueryBuilder: " + result);
        return result;
    }
}
