class CreateTables < ActiveRecord::Migration
  def change
    create_table :tables do |t|
      t.boolean :status
      t.integer :capacity
      t.integer :restaurant_id

      t.timestamps null: false
    end
  end
end
