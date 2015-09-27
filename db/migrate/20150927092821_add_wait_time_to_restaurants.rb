class AddWaitTimeToRestaurants < ActiveRecord::Migration
  def change
    add_column :restaurants, :wait_time, :string
  end
end
