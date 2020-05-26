package Password.steps;

import java.io.IOException;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println(System.getProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir")).toRealPath() +  "\\src\\test\\java\\Password\\resources\\chromedriver.exe"));
	}
}
