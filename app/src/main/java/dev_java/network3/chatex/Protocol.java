package dev_java.network3.chatex;

public class Protocol {
  public static final int TALK_IN = 100;
  public static final int MESSAGE = 200;
  public static final int WHISPER = 300;
  public static final int CHANGE = 400;
  public static final int TALK_OUT = 500;

  public static final int WAIT = 600;
  public static final int ROOM_LIST = 700;
  public static final int ROOM_CREATE = 710;
  public static final int ROOM_IN = 720;
  public static final int ROOM_INLIST = 730;
  public static final int ROOM_OUT = 740;
  public static final String seperator = "#";
}
/*
 * final이 클래스 앞에 오면 상속을 못함
 * 메소드 앞에 오면 메소드 오버라이딩을 못함
 * 변수 앞에 오면 상수
 */
