def main () :
    print (" ....... Final Mark Calculator ....... ")
    # Get input marks from the user
    quiz1_mark = float ( input (" Enter the marks for Quiz1: ") )
    quiz2_mark = float ( input (" Enter the marks for Quiz2: ") )
    midterm_mark = float ( input (" Enter the marks forMidterm : ") )
    final_exam_mark = float ( input (" Enter the marks forFinal Exam : ") )
    # Calculate the weighted marks
    quiz1_weighted = quiz1_mark * 0.15
    quiz2_weighted = quiz2_mark * 0.15
    midterm_weighted = midterm_mark * 0.30
    final_exam_weighted = final_exam_mark * 0.40
    # Calculate the Final Mark
    final_mark = quiz1_weighted + quiz2_weighted + midterm_weighted + final_exam_weighted
    # Print the Final Mark
    print ("\nFinal Mark : {:.2f}".format(final_mark))
if __name__ == "__main__":
    main ()
