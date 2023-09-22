package br.com.ada.cielo.primeirodesafio.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;

@Configuration
public class AwsConfig {

	@Value("${aws.accessKeyId}")
	private String accessKeyId;

	@Value("${aws.secretKey}")
	private String secretKey;

	@Value("${aws.region}")
	private String region;

	@Bean
	AmazonSNS amazonSNS() {
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, secretKey);
		return AmazonSNSClient.builder().withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
	}

	@Bean
	AmazonSQS amazonSQS() {
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, secretKey);
		return AmazonSQSAsyncClient.asyncBuilder()//
				.withRegion(region)//
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
	}

}
