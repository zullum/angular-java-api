import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css'],
})
export class ReviewComponent implements OnInit {
  form: FormGroup;
  changeCount: number = 0;
  constructor(public fb: FormBuilder, private http: HttpClient) {
    this.form = this.fb.group({
      firstName: [''],
      lastName: [''],
    });
  }
  ngOnInit() {}

  submitForm() {
    var formData: any = {};
    const firstName = this.form.get('firstName')?.value ?? '';
    formData.firstName = firstName;
    const lastName = this.form.get('lastName')?.value ?? '';
    formData.lastName = lastName;
    this.http.post('http://localhost:8081/api/save', formData).subscribe(
      (response) => {
        console.log(response);
        this.changeCount++;
      },
      (error) => console.log(error)
    );
  }
}
