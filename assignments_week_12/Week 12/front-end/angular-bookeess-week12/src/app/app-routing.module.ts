import{NgModule} from'@angular/core'
import { RouterModule, Routes } from '@angular/router';
import { AdminLogInComponent} from './admin-log-in/admin-log-in.component';
import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserLogInComponent } from './user-log-in/user-log-in.component';
import { UserComponent } from './user/user.component';



const routes:Routes=[
    {path:"adminLogin", component:AdminLogInComponent },
    {path:"userLogin", component:UserLogInComponent },
    {path:"viewBook", component:BooksComponent},
    {path:"home", component:DashboardComponent},
    {path:"user",component:UserComponent}
];
@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]

})
export class AppRoutingModule{}

