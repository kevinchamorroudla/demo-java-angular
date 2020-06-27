package org.udla.config;

import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurationContext;
import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurer;

public class configurer implements ElasticsearchAnalysisConfigurer {
    @Override
    public void configure(ElasticsearchAnalysisConfigurationContext context) {
//        context.analyzer("nombre").custom()
//                .tokenizer("standard")
//                .tokenFilters("asciifolding", "lowercase");
//
//        context.analyzer("english").custom()
//                .tokenizer("standard")
//                .tokenFilters("asciifolding", "lowercase", "porter_stem");
//
//        context.normalizer("sort").custom()
//                .tokenFilters("asciifolding", "lowercase");
    }
}
