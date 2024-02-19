package kz.tutorial.jsonplaceholdertypicode.presentation.users.user

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.client.GetUserUseCase
import kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo_user.LayoutStatus
import kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo_user.PhotoState

import kz.tutorial.jsonplaceholdertypicode.presentation.users.UsersState
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.DEFAULT_STRING

class UserViewModel(private val getUserUseCase:GetUserUseCase, private val id:Int):ViewModel() {
    private val _userDetailsLiveData: MutableLiveData<UserState> = MutableLiveData()
    val userDetailsLiveData: LiveData<UserState> = _userDetailsLiveData
    private lateinit var  address: Uri
    init {
        getUser()
    }
    private fun getUser() {
        viewModelScope.launch {
            val user = getUserUseCase.getUser(id)

            if (user != null ) {
                val geo = user.address?.geo
                val userAddress = user.address
                address = Uri.parse("geo:" + geo?.lat + "," + geo?.lng + "?q=" + Uri.encode(userAddress?.street + ", " + userAddress?.city + ", " + userAddress?.zipcode))
                _userDetailsLiveData.postValue(UserState.Success(user))
            } else {
                _userDetailsLiveData.postValue(UserState.Error(error("null")))
            }
        }
    }

    fun openLocation(){
        _userDetailsLiveData.postValue(UserState.ShowOnMap(address))
    }
}