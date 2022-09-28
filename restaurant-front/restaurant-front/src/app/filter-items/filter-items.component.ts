import { Component, EventEmitter, OnInit, Output } from '@angular/core';


@Component({
  selector: 'app-filter-items',
  templateUrl: './filter-items.component.html',
  styleUrls: ['./filter-items.component.css']
})
export class FilterItemsComponent implements OnInit {
  @Output() setNameFilter: EventEmitter<NameFilter> = new EventEmitter();

  public nameFilter: NameFilter;
  public JSON: Object = JSON;

  constructor() {
    this.nameFilter = {
      name: ""
    };
   }

  ngOnInit() {
  }

  filterItems() {
    console.log(this.nameFilter.name)
    this.setNameFilter.emit(this.nameFilter);
  }

}

export interface NameFilter {
  name: string;
}
