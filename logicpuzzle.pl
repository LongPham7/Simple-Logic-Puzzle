% Source: The Art of Prolog by Ehud Shapiro and Leon Sterling

% General structure to solve a logic puzzle

solve_puzzle(puzzle(Clues, Queries), Solution) :-
  solve(Clues), solve(Queries).

solve([Clue|Clues]) :- call(Clue), solve(Clues).
solve([]).

% Test rig

test_puzzle(Name, Solution) :-
  structure(Name, Structure),
  clues(Name, Structure, Clues),
  queries(Name, Structure, Queries, Solution),
  solve_puzzle(puzzle(Clues, Queries), Solution).

structure(test, [friend(N1, C1, S1), friend(N2, C2, S2), friend(N3, C3, S3)]).

clues(test, Friends,
  [(did_better(Man1Clue1, Man2Clue1, Friends),           % Clue 1
  first_name(Man1Clue1, michael), sport(Man1Clue1, basketball),
  nationality(Man2Clue1, american)),
  (did_better(Man1Clue2, Man2Clue2, Friends),            % Clue 2
  first_name(Man1Clue2, simon), nationality(Man1Clue2, israeli),
  sport(Man2Clue2, tennis)),
  (first(Friends, ManClue3), sport(ManClue3, cricket))   % Clue 3
  ]).

queries(test, Friends,
  [member(Q1, Friends),
  first_name(Q1, Name),
  nationality(Q1, australian),
  member(Q2, Friends),
  first_name(Q2, richard),
  sport(Q2, Sport)],
  Name).

did_better(A, B, [A,B,C]).
did_better(A, C, [A,B,C]).
did_better(B, C, [A,B,C]).

first_name(friend(A,B,C), A).
nationality(friend(A,B,C), B).
sport(friend(A,B,C), C).

first([X|Xs], X).
