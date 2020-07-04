package org.zerosky20;

import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.zerosky20.domain.Board;
import org.zerosky20.repository.BoardRepository;
import org.zerosky20.utils.CurrentInfo;
import org.zerosky20.utils.Flag;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class Board01Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Board01Application.class, args);
	}

	///////////////////////////////////////////////////////////////////////////////////

	@Override
	public void run(String... args) throws Exception {
		log.info("KANG-20200618 >>>>> {}", CurrentInfo.get());
		
		if (Flag.flag) job01();
		if (Flag.flag) job02();
	}

	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private BoardRepository boardRepository;
	
	private void job01() throws Exception {
		log.info("KANG-20200618 >>>>> {}", CurrentInfo.get());
		
		Random random = new Random(new Date().getTime());
		
		IntStream.rangeClosed(1, 200).forEach(index -> {
			String userId = null;
			if (Flag.flag) {
				switch (random.nextInt(1000) % 3) {
				case 1: userId = "kiea"; break;
				case 2: userId = "kang"; break;
				default: userId = "seok"; break;
				}
			}
			
			this.boardRepository.save(Board.builder()
					.title("제목-" + index)
					.subTitle("부제목" + index)
					.content("내용입니다. 안녕하세요...")
					.userId(userId)
					.build());
		});
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	private void job02() throws Exception {
		log.info("KANG-20200618 >>>>> {}", CurrentInfo.get());
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
}
