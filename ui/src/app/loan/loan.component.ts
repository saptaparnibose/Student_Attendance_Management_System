import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {
  title = "Loan Here!!"
  loans = [
    {
      "id": 1,
      "bookId": 50,
      "studentId": 4,
      "checkoutDate": "09-10-2012",
      "dueDate": "23-12-2012",
      "returnDate": "19-12-2012"
    },
    {
      "id": 33,
      "bookId": 203,
      "studentId": 30,
      "checkoutDate": "09-09-2014",
      "dueDate": "10-10-2014",
      "returnDate": "11-11-2014"
    }
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
