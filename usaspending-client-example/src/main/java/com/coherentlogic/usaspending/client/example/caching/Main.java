package com.coherentlogic.usaspending.client.example.caching;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.coherent.data.model.core.cache.CacheServiceProviderSpecification;
import com.coherentlogic.coherent.data.model.core.cache.MapCompliantCacheServiceProvider;
import com.coherentlogic.usaspending.client.core.builders.Detail;
import com.coherentlogic.usaspending.client.core.builders.QueryBuilder;
import com.coherentlogic.usaspending.client.core.domain.Complete;
import com.jamonapi.MonKey;
import com.jamonapi.MonKeyImp;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String REST_TEMPLATE_BEAN_ID
        = "usaSpendingRestTemplate";

    private static final ApplicationContext context
        = new FileSystemXmlApplicationContext (
            "src/main/resources/spring/caching-enabled-application-context.xml"
        );

    private static final MonKey monKey = new MonKeyImp(
        "Call USASpending.gov web services and return an instance of a " +
        "domain class.", TimeUnit.MILLISECONDS.toString());

    public static void main(String[] args) throws InterruptedException {

        RestTemplate restTemplate =
            (RestTemplate) context.getBean(REST_TEMPLATE_BEAN_ID);

        Map<String, Object> completeCache = new HashMap<String, Object> ();

        CacheServiceProviderSpecification <String, Object>
            cacheServiceProvider = new MapCompliantCacheServiceProvider
                <String, Object> (completeCache);

        QueryBuilder queryBuilder = new QueryBuilder (
            restTemplate, "https://www.usaspending.gov/", cacheServiceProvider);

        Monitor monitor = MonitorFactory.start(monKey);

        Complete complete = null;

        //for (int ctr = 0; ctr < 9; ctr++) {

            //log.info("ctr: " + ctr);

            complete =
                queryBuilder
                    .fsrs()
                    .setFiscalYear("2000")
                    .setStateCode("TX")
                    .setDetail(Detail.complete)
                    .setMaxRecords(500)
                    .doGet(Complete.class);

            String escapedUri = queryBuilder.getEscapedURI();

            log.info ("uri:" + escapedUri + ", cache contains? " +
                (completeCache.get(escapedUri) != null));

            log.info ("JAMon (intermediate) report: " + monitor);
        //}

        monitor.stop();
        log.info ("JAMon (final) report: " + monitor);

        log.info("Program ends.");
    }
}
