package br.pro.hashi.ensino.desagil.desafio.model;

import java.awt.*;

public class Model {
    private final Board board;
    private final Element target;
    private final HumanPlayer humanPlayer;
    private final CpuPlayer cpuPlayer;

    private Player winner;

    public Model() {
        board = new Board("board.txt");

        target = new Element(4, 14);

        humanPlayer = new HumanPlayer(0, 0, board);

        cpuPlayer = new CpuPlayer(8, 18, board);

        winner = null;
    }

    public Player getWinner() {
      if (humanPlayer.getRow() == target.getRow() && humanPlayer.getCol() == target.getCol()) {
        cpuPlayer.move(0,0);
        winner = humanPlayer;
      }
      else if (cpuPlayer.getRow() == target.getRow() && cpuPlayer.getCol() == target.getCol()) {
        humanPlayer.move(0,0);
        winner = cpuPlayer;
      }
      return winner;
    }


    public void setWinner(Player winner) {
        this.winner = winner;
        if (winner == cpuPlayer) {
          Graphics.drawString("computador venceu", 0, 0);
        }
        else if (winner == humanPlayer) {
          Graphics.drawString("humano venceu", 0,0);
        }
    }

    public Board getBoard() {
        return board;
    }

    public Element getTarget() {
        return target;
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public CpuPlayer getCpuPlayer() {
        return cpuPlayer;
    }
}
