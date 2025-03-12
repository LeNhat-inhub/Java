import constant.Common;
import object.*;
import other.Menu;
import repo.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static constant.Common.scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        Scanner sc = Common.getScanner();

        Menu menu = new Menu();
        menu.menuProgram(sc);
    }
}
