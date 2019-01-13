package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.control;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
public class Command {
    @Getter
    private CommandType type;
    private List<String> arguments;

    public Command(CommandType type, List<String> arguments) {
        this.type = type;
        this.arguments = arguments;
    }

    public Command(CommandType type) {
        this.type = type;
        this.arguments = null;
    }

    public String getArgAtPos(int position) {
        return arguments != null ? arguments.get(position) : null;
    }

    private boolean checkEnoughArgs(int argsAmount) {
        boolean result = true;
        for (int i = 0; i < argsAmount; i++) {
            try {
                String arg = arguments.get(i);
                if (arg == null) {
                    result = false;
                }
            } catch (IndexOutOfBoundsException e) {
                result = false;
            }
        }
        return result;
    }

    public boolean checkWrongArgs() {
        boolean result = false;
        int argsAmount = 0;
        switch (type) {
            case GET_COST:
                argsAmount = 1;
                if (!checkEnoughArgs(argsAmount)) {
                    result = true;
                }
                break;
            case CHANGE_COST:
                argsAmount = 2;
                if (checkEnoughArgs(argsAmount)) {
                    try {
                        Double.parseDouble(this.getArgAtPos(1));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        result = true;
                    }
                } else {
                    result = true;
                }
                break;
            case GET_GOODS_IN_A_COST_RANGE:
                argsAmount = 2;
                if (checkEnoughArgs(argsAmount)) {
                    try {
                        Double.parseDouble(this.getArgAtPos(0));
                        Double.parseDouble(this.getArgAtPos(1));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        result = true;
                    }
                } else {
                    result = true;
                }
                break;
        }
        return result;
    }
}
