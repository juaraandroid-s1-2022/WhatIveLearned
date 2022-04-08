/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package dev.witheredflowers.whativelearned.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.witheredflowers.whativelearned.R
import dev.witheredflowers.whativelearned.dogglers.const.Layout
import dev.witheredflowers.whativelearned.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
	private val context: Context?,
	private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
	
	// Initialize the data using the List found in data/DataSource
	private val dataDogs = DataSource.dogs
	
	/**
	 * Initialize view elements
	 */
	class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
		// Declare and initialize all of the list item UI components
		val imgDogs: ImageView = view!!.findViewById(R.id.imgDogglers)
		val txtDogName: TextView = view!!.findViewById(R.id.txtDogName)
		val txtDogAge: TextView = view!!.findViewById(R.id.txtDogAge)
		val txtDogHobbies: TextView = view!!.findViewById(R.id.txtDogHobbies)
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
		// Use a conditional to determine the layout type and set it accordingly.
		//  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
		//  the vertical/horizontal list item should be used.
		val whichLayout = when(layout) {
			Layout.GRID ->R.layout.grid_list_item
			else -> R.layout.vertical_horizontal_list_item
		}
		
		// Inflate the layout
		val layout = LayoutInflater.from(parent.context).inflate(whichLayout, parent, false)
		
		// Null should not be passed into the view holder. This should be updated to reflect
		//  the inflated layout.
		return DogCardViewHolder(layout)
	}
	
	override fun getItemCount(): Int = dataDogs.size // return the size of the data set instead of 0
	
	override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
		val resources = context?.resources
		
		// Get the data at the current position
		val currentDog = dataDogs[position]
		
		// Set the image resource for the current dog
		// Set the text for the current dog's name
		// Set the text for the current dog's age
		holder.imgDogs.setImageResource(currentDog.imageResourceId)
		holder.txtDogName.text = resources?.getString(R.string.dog_name, currentDog.name)
		holder.txtDogAge.text = resources?.getString(R.string.dog_age, currentDog.age)
		
		// Set the text for the current dog's hobbies by passing the hobbies to the
		//  R.string.dog_hobbies string constant.
		//  Passing an argument to the string resource looks like:
		//  resources?.getString(R.string.dog_hobbies, dog.hobbies)
		holder.txtDogHobbies.text = resources?.getString(R.string.dog_hobbies, currentDog.hobbies)
	}
}
