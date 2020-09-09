import { Component } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { MessageService } from 'primeng/api';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [MessageService]
})
export class AppComponent {
  isLoading: boolean = false;
  rangeDates: Date[];
  data;
  filterDataObj: any = [];
  title = 'ui';
  constructor(private http: HttpClient, private messageService: MessageService) { }
  ngOnInit() {
    this.isLoading = true;
    this.http.get("http://localhost:8080/list").subscribe((data) => {
      this.data = data;
      this.isLoading = false;
      this.showSuccess()
    })
  }
  filterData() {
    if (this.rangeDates[0] !== null && this.rangeDates[1] !== null) {
      let startDate = this.rangeDates[0].toDateString;
      let endDate = this.rangeDates[1].toDateString;
      this.http.get(`http://localhost:8080/allFilterRecords?startDate=${startDate}&endDate=${endDate}`).
        subscribe((data) => {
          this.data = data;
        })
    }
  }
  showSuccess() {
    this.messageService.add({ key: 'success', severity: 'success', summary: 'Success', detail: this.data.length + ' Records fetched Successfully' });
  }
  clear() {
    this.messageService.clear();
  }
}
