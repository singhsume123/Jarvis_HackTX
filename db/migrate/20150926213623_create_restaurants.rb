class CreateRestaurants < ActiveRecord::Migration
  def change
    create_table :restaurants do |t|
      t.string :name
      t.text :address
      t.string :email
      t.string :phone
      t.integer :avgwaittime

      t.timestamps null: false
    end
  end
end
