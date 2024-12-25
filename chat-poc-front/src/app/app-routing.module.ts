import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SupportComponent } from './components/support/support.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { CarSearchComponent } from './components/car-search/car-search.component';
import { BookingHistoryComponent } from './components/booking-history/booking-history.component';

const routes: Routes = [
  { path: '', redirectTo: '/car-search', pathMatch: 'full' },
  { path: 'profile', component: UserProfileComponent },
  { path: 'car-search', component: CarSearchComponent },
  { path: 'booking-history', component: BookingHistoryComponent },
  { path: 'support', component: SupportComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
