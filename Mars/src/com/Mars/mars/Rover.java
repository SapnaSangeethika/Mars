package com.Mars.mars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Rover {
	//initialize variables
	private int in_x = 0; // bottom left corner 
	private int in_y = 0; //facing North
	private int x; //start point X
	private int y; //start point y
	private String orientation, position;
	private int x_end, y_end; //End point
	String temp;  
	private ArrayList<String> move;
	
	/***
	 * set the start position 
	 */
	public void SetInputs() {
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Enter upper-right coordinates:\n	X:");
			x_end = in.nextInt();
			System.out.print("	Y:");
			y_end = in.nextInt();
			in.nextLine();
			System.out.print("Enter Rover Position:");
			position = in.nextLine();
		}catch(Exception ex) {
			System.out.println("Check the Inputs");
		}
		
	}
	/***
	 * sprit the inputs
	 */
	void processInputs() {
		System.out.println("Position:"+position);
		String[] atr = position.split("\\s+");
		x = Integer.parseInt(atr[0]);
		y = Integer.parseInt(atr[1]);
		orientation = atr[2];
	}
	
	/***
	 * input the moverments
	 */
	void roverMove() {
		Scanner in = new Scanner(System.in);
		try {
			move = new ArrayList<String>();

			int i = 0;

			System.out.print("Enter movement:");
			temp = in.next();

			while (!temp.equals("Q")) {

				if (!temp.equals("Q")) {
					move.add(temp);
					i = i + 1;
				}

				System.out.print("Enter movement:");
				temp = in.next();
			}

			System.out.println("output string: " + Arrays.deepToString(move.toArray()));

		}catch(Exception ex) {
			System.out.println("Check the Inputs");
		}
		
	}
	/***
	 * moverment track
	 */
	void move() {
		for (int i = 0; move.size() > i; i++) {

			String movement = move.get(i);

			if (orientation.equals("N")) {
				if (movement.equals("L")) {
					orientation = "W";

				} else if (movement.equals("R")) {
					orientation = "E";

				} else if (movement.equals("M")) {
					y += 1;
				}

			} else if (orientation.equals("E")) {
				if (movement.equals("L")) {
					orientation = "N";

				} else if (movement.equals("R")) {
					orientation = "S";

				} else if (movement.equals("M")) {
					x += 1;
				}

			} else if (orientation.equals("S")) {
				if (movement.equals("L")) {
					orientation = "E";

				} else if (movement.equals("R")) {
					orientation = "W";

				} else if (movement.equals("M")) {
					y -= 1;
				}

			} else if (orientation.equals("W")) {
				if (movement.equals("L")) {
					orientation = "S";

				} else if (movement.equals("R")) {
					orientation = "N";

				} else if (movement.equals("M")) {
					x -= 1;
				}
			}
		}
		System.out.println("Final Co-ordinate:" + x + " " + y + " Heading:" + orientation);
	}
	/***
	 * Rover process
	 * set the inputs
	 * track the move
	 */
	public void process() {
		Rover r = new Rover();
		r.SetInputs();
		r.processInputs();
		r.roverMove();
		r.move();
	}
	
	public static void main(String[] args) {
		Rover r = new Rover();
		Scanner in = new Scanner(System.in);

		String input;
		System.out.println("Next Rover:N | Quit:Q");
		System.out.print("Input:");
		input = in.next();

		while (!input.equals("Q")) {

			r.process();

			System.out.println("Next Rover:N | Quit:Q");
			System.out.print("Input:");
			input = in.next();

		}
		
		System.out.println("Thanks!");
	}
}

