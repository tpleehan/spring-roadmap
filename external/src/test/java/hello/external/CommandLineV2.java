package hello.external;

import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV2 {

	// --url=devdb --username=dev_user --password=dev_pw mode=on
	public static void main(String[] args) {
		for (String arg : args) {
			log.info("arg {}", arg);
		}

		ApplicationArguments appArgs = new DefaultApplicationArguments(args);
		log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));
		log.info("getNonOptionArgs = {}", List.of(appArgs.getNonOptionArgs()));
		log.info("getOptionNames = {}", List.of(appArgs.getOptionNames()));

		Set<String> optionNames = appArgs.getOptionNames();
		for (String optionName : optionNames) {
			log.info("option args {}={}", optionName, appArgs.getOptionValues(optionName));
		}

		List<String> url = appArgs.getOptionValues("url");
		List<String> username = appArgs.getOptionValues("username");
		List<String> password = appArgs.getOptionValues("password");
		List<String> mode = appArgs.getOptionValues("mode");
		log.info("url={}", url);
		log.info("username={}", username);
		log.info("password={}", password);
		log.info("mode={}", mode);
	}
}
