import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { AppService } from '../app.service';
import { Item, Page } from '../common.models';
import { NameFilter } from '../filter-items/filter-items.component';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  items: Item[];
  updateItem: Item;

  public nameFilter: NameFilter;
  public pageNo: number = 0;

  public username = window.localStorage.getItem('username');

  constructor(private appService: AppService) { 
    this.items = [];
    this.updateItem = {
      name: "",
      price: 0,
      category: {}
    };

    this.nameFilter = {
      name: ""
    };
  }

  ngOnInit() {
    this.getItems();
    console.log(this.items);
  }

  getItems() {
    this.appService
      .getItems(this.nameFilter.name, this.pageNo)
      .subscribe((res: Item[]) => ( this.items = res ))
  }

  filterItems(nameFilter: NameFilter) {
    this.nameFilter = nameFilter;
    this.pageNo = 0;
    this.getItems();
  }

  changePage(page: Page) {
    console.log(page);
    if (page == 0) {
      this.pageNo = this.pageNo - 1;
    } else {
      this.pageNo = this.pageNo + 1;
    }
    console.log(this.pageNo);
    this.getItems();

  }

  delete(id: any) {
    if(window.localStorage.getItem('username') != null) {
      this.appService.deleteItem(id).subscribe((res: Item) => {
        this.getItems();
      });
    }
  }

  setUpdateItem(item: Item) {
    this.updateItem = item;
  }
  

  
}
