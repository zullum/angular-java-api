import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css'],
})
export class CustomersComponent implements OnInit, OnChanges {
  @Input() changeCount: any | undefined;
  constructor(private http: HttpClient) {}
  public customers: any = [];
  ngOnInit(): void {
    this.http.get('http://localhost:8081/api/findall').subscribe(
      (response) => (this.customers = response),
      (error) => console.log(error)
    );
  }

  ngOnChanges(): void {
    this.http.get('http://localhost:8081/api/findall').subscribe(
      (response) => (this.customers = response),
      (error) => console.log(error)
    );
  }
}
