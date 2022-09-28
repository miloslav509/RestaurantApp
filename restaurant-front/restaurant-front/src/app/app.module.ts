import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
 
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { MenuComponent } from './menu/menu.component';
import { FilterItemsComponent } from './filter-items/filter-items.component';
import { ChangePageComponent } from './change-page/change-page.component';
import { AddItemComponent } from './add-item/add-item.component';
import { LoginComponent } from './login/login.component';


const appRoutes: Routes = [
  { path: 'menu', component: MenuComponent },
  { path: 'main', component: MainComponent },
  { path: 'login', component: LoginComponent },  
  { path: '', redirectTo: 'main', pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    MenuComponent,
    FilterItemsComponent,
    ChangePageComponent,
    AddItemComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
