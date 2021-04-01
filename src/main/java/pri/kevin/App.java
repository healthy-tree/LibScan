package pri.kevin;

import org.apache.commons.cli.*;

import java.util.List;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    CommandLineParser parser = new DefaultParser();
    Options options = getOptions();
    HelpFormatter formatter = new HelpFormatter();

    try {
      CommandLine cmd = parser.parse(options, args);
      if (cmd.hasOption("p")) {
        String p = cmd.getOptionValue("p");
        System.out.println(p);
      } else if (cmd.hasOption("o")) {
        System.out.println(cmd.getOptionValue("o"));
      }else {
        formatter.printHelp("Shared Library Scan Tools", options);
      }

    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  /**
   * 初始化命令行参数
   *
   * @return cmd 参数选项
   */
  private static Options getOptions() {
    Options options = new Options();
    Option libPath = new Option("p", "lib-path", true, "Shared Library path");
    libPath.setRequired(true);
    options.addOption(libPath);
    Option outputPath = new Option("o", "output-path", true, "Result Files output path");
    outputPath.setRequired(false);
    options.addOption(outputPath);
    options.addOption("h", "help", false, "this message");
    return options;
  }

  /** 打印帮助信息 */
  private static void helpMessage() {}
}
