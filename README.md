# java-game-of-life
Java implementation of the famous Conway's Game of Life, just for fun.

# Overview

Conway's Game of Life is a cellular automaton invented by John Conway in the 70's.
The game has no players, meaning that its evolution is determined by its initial state, requiring no further input.

## Rules of Life

The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells, each of which is in one of two possible states: alive or dead. Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:

1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

## Patterns

Many different types of patterns occur in the Game of Life, which are classified according to their behaviour. Common pattern types include: still lifes, which do not change from one generation to the next; oscillators, which return to their initial state after a finite number of generations; and spaceships, which translate themselves across the grid.

*Inspired by Wikipedia. Go to https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life for more information.*

# Implementation

The universe is represented by a matrix of integers where the zeros are dead cells and the 1s are alive. The initial state is computed by random positioning a defined number of cells (called AdamEve cells) on the grid. 
By editing "UNIVERSE_HEIGHT" and "UNIVERSE_WIDTH" in the "Universe" class you can change the dimension of the grid, increasing the size of your universe. You should always use a square universe, by setting the same value for both variables. You can also increase the number of cells by reducing "CELL_SIZE", but you should always choose a size which is a submultiple of UNIVERSE_HEIGHT or UNIVERSE_WIDTH.

All the cells outside the boundaries of the grid are assumed dead, and they can't change their status. This leads to inaccurate results when the active area crosses the boundary. This will probably be fixed in the future.
