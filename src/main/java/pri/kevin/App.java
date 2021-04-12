package pri.kevin;

import org.apache.commons.cli.*;

import java.util.Iterator;
import java.util.List;

/** Hello world! */
public class App {

  private static HelpFormatter formatter;
  private static DirTools dirTools;

  static {
    formatter = new HelpFormatter();
    dirTools = new DirTools();
  }

  public static void main(String[] args) {
    Options options = getOptions();
    if (args.length <= 0) {
      helpMessage();
      return;
    }

    CommandLineParser parser = new DefaultParser();
    try {
      CommandLine cmd = parser.parse(options, args, false);
      if (cmd.hasOption('o') && cmd.hasOption('p')) {
        dirTools.scanDirs(cmd.getOptionValue('p'));

        System.out.println("App.main"+cmd.getOptionValue('o'));
        System.out.println("App.main"+cmd.getOptionValue('p'));
      } else {
        helpMessage();
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }finally{
      helpMessage();
      System.exit(1);
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
    libPath.setRequired(false);
    options.addOption(libPath);
    Option outputPath = new Option("o", "output-path", true, "Result Files output path");
    outputPath.setRequired(false);
    options.addOption(outputPath);
    options.addOption("h", "help", false, "this message");
    return options;
  }

  /** 打印帮助信息 */
  private static void helpMessage() {
    Options options = getOptions();
    formatter.printHelp("Shared Library Scan Tools", options);
  }
}
