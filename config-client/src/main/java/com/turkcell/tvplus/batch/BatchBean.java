package com.turkcell.tvplus.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchBean {
	
	private Logger logger = LoggerFactory.getLogger(BatchBean.class);
	
	@Scheduled(cron = "${batch.greeting.cron}")
	public void cronJob(){
		logger.info("[BatchBean] [cronJob] cron job is executed");
	}

}
