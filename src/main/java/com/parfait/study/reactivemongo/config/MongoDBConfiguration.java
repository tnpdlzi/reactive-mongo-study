package com.parfait.study.reactivemongo.config;

import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parfait.study.reactivemongo.config.converter.PostBodyConverter;

@Configuration
public class MongoDBConfiguration {

	@Bean
	public MongoClientSettingsBuilderCustomizer mongoClientOptions() {
		return settingBuilder -> {
			settingBuilder.applyToConnectionPoolSettings(poolSettingBuilder -> {
				poolSettingBuilder.maxSize(2);
				poolSettingBuilder.minSize(2);
			});
		};
	}

//	@Bean
//	@ConditionalOnMissingBean(MongoConverter.class)
//	public MappingMongoConverter mappingMongoConverter(MongoMappingContext context,
//													   MongoCustomConversions conversions,
//													   ConverterRegistry converterRegistry) {
//		MappingMongoConverter mappingConverter = new MappingMongoConverter(NoOpDbRefResolver.INSTANCE, context);
//
//		converterRegistry.addConverter(postBodyConverter());
//		conversions.registerConvertersIn(converterRegiste);
//		mappingConverter.setCustomConversions(conversions);
//		return mappingConverter;
//	}

	@Bean
	public PostBodyConverter postBodyConverter() {
		return new PostBodyConverter();
	}
}