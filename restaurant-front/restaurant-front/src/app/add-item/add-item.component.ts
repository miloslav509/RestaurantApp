import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { CategoryIntegface, Item } from '../common.models';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
  
  @Input() newItem: Item;
  public categories: CategoryIntegface[] = [];

  constructor(private appService: AppService, private route: Router) {
    this.newItem = new Item({
      name: '',
      category: {},
      price: 0
    })
   }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.appService.getCategories().subscribe((res: CategoryIntegface[]) => {
      this.categories = res;
    });
  }

  addItem() {
    if(window.localStorage.getItem('username') != null) {
      this.appService.addItem(this.newItem).subscribe((res: Item) => {
        this.newItem = res;
        this.route.navigate(['/menu']);
        this.reset();
      })
    } 
    
  }

  reset() {
    this.newItem = new Item({
      name: '',
      category: {},
      price: 0
    })
  }

}
